package com.circuito.components.memory

import com.circuito.components.{Bit, Component, Signal}

class RAM(memorySize: Int, wordSize: Int) extends Component(
  nInputs = wordSize + IntMath.log2Ceil(memorySize) + 1, // Data input, address input, write enable input
  nOutputs = wordSize,
  Inputs = List.fill(wordSize + IntMath.log2Ceil(memorySize) + 1)(new Signal(Bit.Zero)),
  Outputs = List.fill(wordSize)(new Signal(Bit.Zero))
) {
  private val memory: Array[Array[Boolean]] = Array.fill(memorySize)(Array.fill(wordSize)(false))
  
  override def computeOutput(inputs: List[Signal]): List[Signal] = {
    val dataIn = inputs.take(wordSize).map(_.getValue)
    val address = inputs.slice(wordSize, wordSize + IntMath.log2Ceil(memorySize)).map(_.getValue).zipWithIndex.foldLeft(0)((acc, bit) => acc + (if (bit._1) 1 << bit._2 else 0))
    val writeEnable = inputs.last.getValue
    
    if (writeEnable) {
      memory(address) = dataIn.toArray
    }
    
    Outputs.zipWithIndex.foreach { case (output, i) =>
      output.setValue(memory(address)(i))
    }
    
    Outputs
  }
}

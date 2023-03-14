package com.circuito.components.seqgates

import com.circuito.components.memory.FlipFlop
import com.circuito.components.{Component, Signal, Bit}
import com.circuito.components.gates.NorGate

class SRLatch extends Component(nInputs = 2, nOutputs = 2, Inputs = List(new Signal(Bit.Zero), new Signal(Bit.Zero)),
  Outputs = List(new Signal(Bit.Zero), new Signal(Bit.Zero))) {

  private val nor1 = new NorGate()
  private val nor2 = new NorGate()

  nor1.setOutput(1, flipFlop.getInputs(0))
  nor2.setOutput(1, nor1.getOutputs.head)
  nor2.setOutput(0, flipFlop.getInputs(1))
  
  override def computeOutput(inputs: List[Signal]): List[Signal] = {
    val s = inputs.head.getValue
    val r = inputs.last.getValue
    
    if (s == Bit.One && r == Bit.Zero) {
      flipFlop.setInputs(List(new Signal(Bit.One), new Signal(Bit.Zero)))
    } else if (s == Bit.Zero && r == Bit.One) {
      flipFlop.setInputs(List(new Signal(Bit.Zero), new Signal(Bit.One)))
    }
    
    Outputs.head.setValue(flipFlop.getOutputs.head.getValue)
    Outputs.last.setValue(flipFlop.getOutputs.last.getValue)
    Outputs
  }
}

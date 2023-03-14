package com.circuito.components.gates

import com.circuito.{Bit, Signal}

class XorGate extends Gate(nInputs = 2, nOutputs = 1) {
  override protected def computeOutput(inputs: List[Signal]): List[Signal] = {
    val input1 = inputs.head
    val input2 = inputs(1)
    val outputValue = if (input1.getValue == input2.getValue) Bit.Zero else Bit.One
    List(new Signal(outputValue))
  }
}

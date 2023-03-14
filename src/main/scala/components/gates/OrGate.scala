package com.circuito.components.gates

import com.circuito.{Bit, Signal}

class OrGate extends Gate(nInputs = 2, nOutputs = 1) {
  override protected def computeOutput(inputs: List[Signal]): List[Signal] = {
    val input1 = inputs.head
    val input2 = inputs(1)
    val outputValue = if (input1.getValue == Bit.One || input2.getValue == Bit.One) Bit.One else Bit.Zero
    List(new Signal(outputValue))
  }
}

package com.circuito.components.gates

import com.circuito.{Bit, Signal}

class NotGate extends SingleGate(nInputs = 1, nOutputs = 1) {
  override protected def computeOutput(inputs: List[Signal]): List[Signal] = {
    val input = inputs.head
    val outputValue = if (input.getValue == Bit.Zero) Bit.One else Bit.Zero
    List(new Signal(outputValue))
  }
}

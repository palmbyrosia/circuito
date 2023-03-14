package com.circuito.components.gates

import com.circuito.components.{Component, Signal}
import com.circuito.components.ionode.Bit

class EqGate extends Component(nInputs = 2, nOutputs = 1, Inputs = List.fill(2)(new Signal(Bit.Zero)), Outputs = List(new Signal(Bit.Zero))) {
  override def computeOutput(inputs: List[Signal]): List[Signal] = {
    val input1 = inputs.head.getValue
    val input2 = inputs(1).getValue
    if (input1 == input2) {
      Outputs.head.setValue(Bit.One)
    } else {
      Outputs.head.setValue(Bit.Zero)
    }
    Outputs
  }
}

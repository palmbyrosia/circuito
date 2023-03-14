package com.circuito.components.ionode

import com.circuito.components.{Component, Signal}

class LED extends Component(nInputs = 1, nOutputs = 0, Inputs = List(new Signal(Bit.Zero)), Outputs = Nil) {
  on = false
  override def computeOutput(inputs: List[Signal]): List[Signal] = {
    on = inputs.head.getValue == 1
    Nil
  }
}

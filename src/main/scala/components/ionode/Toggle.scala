package com.circuito.components.ionode

import com.circuito.components.{Component, Signal}

class Toggle extends Component(nInputs = 0, nOutputs = 1, Inputs = Nil, Outputs = List(new Signal(Bit.Zero))) {
  override def computeOutput(inputs: List[Signal]): List[Signal] = {
    Outputs
  }

    def toggle(): Unit = {
        Outputs.head.setValue(Outputs.head.getValue.flip)
    }
}

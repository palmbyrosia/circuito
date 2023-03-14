package com.circuito.components.memory

import com.circuito.components.{Component, Signal}

class FlipFlop extends Component(nInputs = 1, nOutputs = 2, Inputs = List(new Signal(Bit.Zero)), Outputs = List(new Signal(Bit.Zero), new Signal(Bit.Zero))) {
  override def computeOutput(inputs: List[Signal]): List[Signal] = {
    Outputs.head.setValue(inputs.head.getValue)
    Outputs(1).setValue(inputs.head.getValue)
    Outputs
  }
}

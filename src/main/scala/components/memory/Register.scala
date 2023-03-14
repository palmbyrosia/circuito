package com.circuito.components.memory

import com.circuito.components.{Component, Signal}

class Register extends Component(nInputs = 2, nOutputs = 1, Inputs = List.fill(2)(new Signal(Bit.Zero)), Outputs = List(new Signal(Bit.Zero))) {
  private val flipFlop = new FlipFlop()
  
  override def computeOutput(inputs: List[Signal]): List[Signal] = {
    flipFlop.computeOutput(List(inputs.head, Outputs.head))
    Outputs.head.setValue(flipFlop.getOutputs.head.getValue)
    Outputs
  }
}

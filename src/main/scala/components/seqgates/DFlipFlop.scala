package com.circuito.components.seqgates

import com.circuito.components.memory.FlipFlop
import com.circuito.components.{Component, Signal, Bit}

class DFlipFlop extends Component(nInputs = 2, nOutputs = 2,
  Inputs = List.fill(2)(new Signal(Bit.Zero)), Outputs = List(new Signal(Bit.Zero), new Signal(Bit.Zero))) {

  private val flipFlop = new FlipFlop()

  override def computeOutput(inputs: List[Signal]): List[Signal] = {
    flipFlop.computeOutput(List(inputs(1), inputs(0)))
    Outputs.head.setValue(flipFlop.getOutputs.head.getValue)
    Outputs(1).setValue(flipFlop.getOutputs.last.getValue)
    Outputs
  }
}

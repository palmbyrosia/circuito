package com.circuito.components.seqgates

import com.circuito.components.{Component, Signal}
import com.circuito.components.ionode.Bit
import com.circuito.components.memory.FlipFlop

class DLatch extends Component(nInputs = 2, nOutputs = 2,
  Inputs = List.fill(2)(new Signal(Bit.Zero)), Outputs = List.fill(2)(new Signal(Bit.Zero))) {

  private val flipFlop1 = new FlipFlop()
  private val flipFlop2 = new FlipFlop()

  override def computeOutput(inputs: List[Signal]): List[Signal] = {
    flipFlop1.computeOutput(List(inputs.head, flipFlop2.getOutputs.head))
    flipFlop2.computeOutput(List(flipFlop1.getOutputs.head, inputs.head))

    Outputs.head.setValue(flipFlop1.getOutputs.head.getValue)
    Outputs(1).setValue(flipFlop2.getOutputs.head.getValue)

    Outputs
  }
}

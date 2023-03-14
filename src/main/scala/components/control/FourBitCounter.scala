package com.circuito.components.control

import com.circuito.components.{Bit, Component, Signal}

class FourBitCounter extends Component(nInputs = 2, nOutputs = 4, Inputs = List.fill(2)(new Signal(Bit.Zero)), Outputs = List.fill(4)(new Signal(Bit.Zero))) {
  private val counter = new Counter(4)

  override def computeOutput(inputs: List[Signal]): List[Signal] = {
    counter.increment(inputs.head.getValue)
    counter.getOutput.map(b => new Signal(b))
  }
}

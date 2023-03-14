package com.circuito.components.control

import com.circuito.components.{Component, Signal}

class Counter extends Component(nInputs = 2, nOutputs = 1, Inputs = List.fill(2)(new Signal(Bit.Zero)), Outputs = List(new Signal(Bit.Zero))) {

  private var count: Int = 0

  override def computeOutput(inputs: List[Signal]): List[Signal] = {
    val enable = inputs.head.getValue
    val reset = inputs(1).getValue

    if (reset == 1) {
      count = 0
    } else if (enable == 1) {
      count += 1
    }

    Outputs.head.setValue(count % 2)

    Outputs
  }
}

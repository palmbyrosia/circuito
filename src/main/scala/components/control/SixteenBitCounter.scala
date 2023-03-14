package com.circuito.components.control

import com.circuito.components.{Component, Signal}

class SixteenBitCounter extends Component(nInputs = 2, nOutputs = 16,
  Inputs = List(new Signal(Bit.Zero), new Signal(Bit.Zero)), Outputs = List.fill(16)(new Signal(Bit.Zero))) {

  private val counters = List.fill(16)(new Counter())

  override def computeOutput(inputs: List[Signal]): List[Signal] = {
    val load = inputs(0).getValue
    val reset = inputs(1).getValue

    val values = counters.map(c => {
      if (reset == 1) {
        0
      } else {
        c.computeOutput(List(new Signal(load))).head.getValue
      }
    })

    for (i <- 0 until 16) {
      Outputs(i).setValue(values(i))
    }
    Outputs
  }
}

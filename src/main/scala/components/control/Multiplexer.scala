package com.circuito.components.control

import com.circuito.components.{Component, Signal}

class Mux extends Component(nInputs = 3, nOutputs = 1, Inputs = List.fill(3)(new Signal(Bit.Zero)), Outputs = List(new Signal(Bit.Zero))) {

  override def computeOutput(inputs: List[Signal]): List[Signal] = {
    val select = inputs(0).getValue
    val input1 = inputs(1).getValue
    val input2 = inputs(2).getValue

    val output = if (select == 0) input1 else input2
    Outputs.head.setValue(output)

    Outputs
  }
}

package com.circuito.components.control

import com.circuito.components.{Component, Signal}

class Encoder extends Component(nInputs = 2, nOutputs = 4,
  Inputs = List.fill(2)(new Signal(Bit.Zero)), Outputs = List.fill(4)(new Signal(Bit.Zero))) {

  override def computeOutput(inputs: List[Signal]): List[Signal] = {
    val (a, b) = (inputs(0).getValue, inputs(1).getValue)

    val c0 = a ^ b
    val c1 = a
    val c2 = b
    val c3 = a | b

    Outputs(0).setValue(c0)
    Outputs(1).setValue(c1)
    Outputs(2).setValue(c2)
    Outputs(3).setValue(c3)

    Outputs
  }
}

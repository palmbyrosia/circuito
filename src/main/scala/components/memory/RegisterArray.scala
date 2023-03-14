package com.circuito.components.memory

import com.circuito.components.{Component, Signal}

class RegisterArray(size: Int) extends Component(nInputs = size + 2, nOutputs = size,
  Inputs = List.fill(size + 2)(new Signal(Bit.Zero)), Outputs = List.fill(size)(new Signal(Bit.Zero))) {

  private val registers = List.fill(size)(new Register())

  override def computeOutput(inputs: List[Signal]): List[Signal] = {
    val load = inputs.head.getValue
    val reset = inputs.tail.head.getValue
    val values = registers.zip(Outputs).map { case (reg, out) =>
      val regInput = if (reset == Bit.One) Bit.Zero else inputs(registers.indexOf(reg) + 2).getValue
      reg.computeOutput(List(new Signal(load), new Signal(regInput))).head.getValue
    }

    for (i <- 0 until size) {
      Outputs(i).setValue(values(i))
    }
    Outputs
  }
}

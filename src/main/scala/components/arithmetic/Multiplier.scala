package com.circuito.components.arithmetic

import com.circuito.components.{Component, Signal}
import com.circuito.components.gates.AndGate

class Multiplier extends Component(nInputs = 2, nOutputs = 1, Inputs = List.fill(2)(new Signal(Bit.Zero)), Outputs = List(new Signal(Bit.Zero))) {
  private val andGate = new AndGate()

  override def computeOutput(inputs: List[Signal]): List[Signal] = {
    val a = inputs.head.getValue
    val b = inputs(1).getValue
    val result = andGate.computeOutput(List(new Signal(a), new Signal(b))).head.getValue
    Outputs.head.setValue(result)
    Outputs
  }
}

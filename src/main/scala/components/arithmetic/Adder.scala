package com.circuito.components.arithmetic

import com.circuito.components.{Component, Signal}
import com.circuito.components.gates.{AndGate, XorGate}

class Adder extends Component(nInputs = 3, nOutputs = 2, Inputs = List.fill(3)(new Signal(Bit.Zero)), Outputs = List(new Signal(Bit.Zero), new Signal(Bit.Zero))) {
  private val andGate1 = new AndGate()
  private val andGate2 = new AndGate()
  private val xorGate = new XorGate()

  override def computeOutput(inputs: List[Signal]): List[Signal] = {
    val a = inputs(0).getValue
    val b = inputs(1).getValue
    val carryIn = inputs(2).getValue

    val sum = xorGate.computeOutput(List(new Signal(a), new Signal(b))).head.getValue
    val carryOut = andGate1.computeOutput(List(new Signal(a), new Signal(b))).head.getValue |
      andGate2.computeOutput(List(new Signal(sum), new Signal(carryIn))).head.getValue

    Outputs.head.setValue(sum)
    Outputs(1).setValue(carryOut)
    Outputs
  }
}

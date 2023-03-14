package com.circuito.components.arithmetic

import com.circuito.components.{Component, Signal}
import com.circuito.components.gates.{AndGate, XorGate}

class FourBitAdder extends Component(nInputs = 8, nOutputs = 4, Inputs = List.fill(8)(new Signal(Bit.Zero)), Outputs = List.fill(4)(new Signal(Bit.Zero))) {

  private val xorGates: List[XorGate] = List.fill(4)(new XorGate())
  private val andGates: List[AndGate] = List.fill(3)(new AndGate())

  override def computeOutput(inputs: List[Signal]): List[Signal] = {
    val a = List(inputs(0).getValue, inputs(1).getValue, inputs(2).getValue, inputs(3).getValue)
    val b = List(inputs(4).getValue, inputs(5).getValue, inputs(6).getValue, inputs(7).getValue)

    val sums: List[Signal] = xorGates.zip(a.zip(b)).map { case (xor, (aVal, bVal)) => xor.computeOutput(List(new Signal(aVal), new Signal(bVal))).head }
    val carrySignals: List[Signal] = andGates.zip(a.zip(b).zip(sums)).map {
      case (andGate, ((aVal, bVal), sumSignal)) => andGate.computeOutput(List(new Signal(aVal), new Signal(bVal), sumSignal.getValue)).head
    }

    Outputs.zip(sums.zip(carrySignals)).foreach { case (out, (sumSignal, carrySignal)) =>
      out.setValue(sumSignal.getValue)
    }

    Outputs.last.setValue(carrySignals.last.getValue)

    Outputs
  }
}

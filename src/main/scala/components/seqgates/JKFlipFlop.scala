package com.circuito.components.seqgates

import com.circuito.components.memory.{FlipFlop, Signal}
import com.circuito.components.ionode.Bit

class JKFlipFlop extends Component(nInputs = 2, nOutputs = 2, Inputs = List.fill(2)(new Signal(Bit.Zero)), Outputs = List.fill(2)(new Signal(Bit.Zero))) {
  private val flipFlop = new FlipFlop()

  override def computeOutput(inputs: List[Signal]): List[Signal] = {
    val jInput = inputs.head.getValue
    val kInput = inputs(1).getValue

    val jSignal = new Signal(jInput)
    val kSignal = new Signal(kInput)

    val notJ = new NOTGate().computeOutput(List(jSignal)).head
    val notK = new NOTGate().computeOutput(List(kSignal)).head

    val sSignal = new ANDGate().computeOutput(List(jSignal, flipFlop.getOutputs(1))).head
    val rSignal = new ANDGate().computeOutput(List(kSignal, flipFlop.getOutputs.head)).head

    val setSignal = new ANDGate().computeOutput(List(notJ, sSignal)).head
    val resetSignal = new ANDGate().computeOutput(List(notK, rSignal)).head

    flipFlop.computeOutput(List(setSignal, resetSignal))

    Outputs.head.setValue(flipFlop.getOutputs.head.getValue)
    Outputs(1).setValue(flipFlop.getOutputs(1).getValue)
    Outputs
  }
}

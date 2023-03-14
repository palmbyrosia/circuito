package com.circuito.components.control

import com.circuito.components.{Component, Signal}

class Demultiplexer extends Component(nInputs = 2, nOutputs = 4, Inputs = List(new Signal(Bit.Zero), new Signal(Bit.Zero)), Outputs = List.fill(4)(new Signal(Bit.Zero))) {
  private val notGate = new NotGate()
  private val andGate1 = new AndGate()
  private val andGate2 = new AndGate()
  private val andGate3 = new AndGate()
  private val andGate4 = new AndGate()

  override def computeOutput(inputs: List[Signal]): List[Signal] = {
    val sel1 = inputs(0).getValue
    val sel2 = inputs(1).getValue

    val notSel1 = notGate.computeOutput(List(new Signal(sel1))).head.getValue
    val notSel2 = notGate.computeOutput(List(new Signal(sel2))).head.getValue

    val in = inputs.head

    Outputs.head.setValue(andGate1.computeOutput(List(new Signal(in.getValue), new Signal(notSel1), new Signal(notSel2))).head.getValue)
    Outputs(1).setValue(andGate2.computeOutput(List(new Signal(in.getValue), new Signal(sel1), new Signal(notSel2))).head.getValue)
    Outputs(2).setValue(andGate3.computeOutput(List(new Signal(in.getValue), new Signal(notSel1), new Signal(sel2))).head.getValue)
    Outputs(3).setValue(andGate4.computeOutput(List(new Signal(in.getValue), new Signal(sel1), new Signal(sel2))).head.getValue)

    Outputs
  }
}

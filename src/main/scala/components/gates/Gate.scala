package com.circuito.components.gates

import com.circuito.components.{Component, Signal}

abstract class Gate extends Component(nInputs = 2, nOutputs = 1, inputs = List(new Signal(Bit.Zero), new Signal(Bit.Zero)), outputs = List(new Signal(Bit.Zero))) {
  protected def computeOutput(input1: Bit, input2: Bit): Bit

  override def update(): Unit = {
    val input1Signal = getInput(0)
    val input1 = input1Signal.getValue
    val input2Signal = getInput(1)
    val input2 = input2Signal.getValue
    val output = computeOutput(input1, input2)
    val outputSignal = getOutput(0)
    outputSignal.setValue(output)
  }
}

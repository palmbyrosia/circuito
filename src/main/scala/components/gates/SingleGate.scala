package com.circuito.components.gates

import com.circuito.components.{Component, Signal}

abstract class SingleGate extends Component(nInputs = 1, nOutputs = 1, inputs = List(new Signal(Bit.Zero)), outputs = List(new Signal(Bit.Zero))) {
  protected def computeOutput(input: Bit): Bit

  override def update(): Unit = {
    val inputSignal = getInput(0)
    val input = inputSignal.getValue
    val output = computeOutput(input)
    val outputSignal = getOutput(0)
    outputSignal.setValue(output)
  }
}



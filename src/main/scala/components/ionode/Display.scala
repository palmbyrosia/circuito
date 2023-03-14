package com.circuito.components.ionode

import com.circuito.components.{Component, Signal}

class Display extends Component(nInputs = 21, nOutputs = 21,
  Inputs = List.fill(21)(new Signal(Bit.Zero)), Outputs = List.fill(21)(new Signal(Bit.Zero))) {

  override def computeOutput(inputs: List[Signal]): List[Signal] = {
    Outputs = Inputs
    Outputs
  }
}
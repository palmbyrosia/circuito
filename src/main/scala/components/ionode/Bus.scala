package com.circuito.components.ionode

import com.circuito.components.{Component, Signal}

class Bus(nBits: Int) extends Component(nInputs = nBits, nOutputs = nBits, 
  Inputs = List.fill(nBits)(new Signal(Bit.Zero)), Outputs = List.fill(nBits)(new Signal(Bit.Zero))) {

  override def computeOutput(inputs: List[Signal]): List[Signal] = {
    for (i <- 0 until nBits) {
      Outputs(i).setValue(inputs(i).getValue)
    }
    Outputs
  }
}

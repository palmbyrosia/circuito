package com.circuito.components.control

import com.circuito.components.{Component, Signal}

class Decoder(nInputs: Int) extends Component(nInputs = nInputs, nOutputs = math.pow(2, nInputs).toInt,
  Inputs = List.fill(nInputs)(new Signal(Bit.Zero)), Outputs = List.fill(math.pow(2, nInputs).toInt)(new Signal(Bit.Zero))) {
  
  override def computeOutput(inputs: List[Signal]): List[Signal] = {
    val numOutputs = math.pow(2, nInputs).toInt
    val inputCode = inputs.map(_.getValue).mkString("")
    val outputCode = Integer.parseInt(inputCode, 2)

    for (i <- 0 until numOutputs) {
      Outputs(i).setValue(if (i == outputCode) Bit.One else Bit.Zero)
    }

    Outputs
  }
}

package com.circuito.components.control

import com.circuito.components.{Component, Signal}

class Clock(val period: Int) extends Component(nInputs = 0, nOutputs = 1, Inputs = Nil, Outputs = List(new Signal(Bit.Zero))) {
  private var tickCount = 0
  
  override def computeOutput(inputs: List[Signal]): List[Signal] = {
    tickCount += 1
    if (tickCount == period) {
      tickCount = 0
      Outputs.head.setValue(Outputs.head.getValue.flip)
    }
    Outputs
  }
}

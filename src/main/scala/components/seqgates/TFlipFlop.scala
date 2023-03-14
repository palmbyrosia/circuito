package com.circuito.components.seqgates

import com.circuito.components.memory.FlipFlop
import com.circuito.components.{Component, Signal}

class TFlipFlop extends Component(nInputs = 2, nOutputs = 2,
  Inputs = List.fill(2)(new Signal(Bit.Zero)), Outputs = List(new Signal(Bit.Zero), new Signal(Bit.Zero))) {
  
  private val flipFlop = new FlipFlop()
  
  override def computeOutput(inputs: List[Signal]): List[Signal] = {
    val T = inputs.head.getValue
    val CLK = inputs(1).getValue
    
    if (CLK == Bit.One) {
      if (T == Bit.One) {
        flipFlop.computeOutput(List(Outputs(1), Outputs(0)))
      } else if (T == Bit.Zero) {
        flipFlop.computeOutput(List(Outputs(0), Outputs(1)))
      }
    }
    
    Outputs
  }
}

package com.circuito.components.gates

class AndGate extends Gate {
  override protected def computeOutput(input1: Bit, input2: Bit): Bit = {
    if (input1 == Bit.One && input2 == Bit.One) Bit.One
    else Bit.Zero
  }
}

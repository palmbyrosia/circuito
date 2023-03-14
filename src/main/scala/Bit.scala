package com.circuito

object Bit extends Enumeration {
  type Bit = Value
  val Zero, One = Value

  implicit class BitOps(val bit: Bit) extends AnyVal {
    def flip: Bit = if (bit == Zero) One else Zero
  }
}
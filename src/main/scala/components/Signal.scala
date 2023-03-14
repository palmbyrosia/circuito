package com.circuito.components

import com.circuito.Bit

class Signal(value: Bit) {
  private var _value: Bit = value

  def getValue: Bit = _value

  def setValue(value: Bit): Unit = {
    _value = value
  }
}

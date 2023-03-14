package com.circuito

import com.circuito.components.{Signal, Bit}

class AssemblyInterpreter(code: String) {
  private val instructionRegex = """^(\w+)\s*(\w+)?\s*(\w+)?$""".r

  def process(): List[Signal] = {
    val instructions = code.split("\n")
    // TODO: Implement this method
  }
}

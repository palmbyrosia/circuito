package com.circuito.components.arithmetic

import com.circuito.components.{Component, Signal}
import com.circuito.components.gates.{AndGate, OrGate, XorGate}

class ALU extends Component(nInputs = 4, nOutputs = 2, Inputs = List.fill(4)(new Signal(Bit.Zero)), Outputs = List(new Signal(Bit.Zero), new Signal(Bit.Zero))) {

  private val adder = new Adder()
  private val andGate = new AndGate()
  private val orGate = new OrGate()
  private val xorGate = new XorGate()
  private val notGate = xorGate // Since NOT gate can be implemented as an XOR gate with one input
  
  override def computeOutput(inputs: List[Signal]): List[Signal] = {
    val a = inputs.head.getValue
    val b = inputs(1).getValue
    val operation = inputs(2).getValue.toInt
    val operationType = inputs(3).getValue

    // Arithmetic operations
    val sum = adder.computeOutput(List(new Signal(a), new Signal(b))).head.getValue
    val difference = adder.computeOutput(List(new Signal(a), new Signal(notGate.computeOutput(List(new Signal(b))).head.getValue), new Signal(Bit.One))).head.getValue

    // Logic operations
    val andResult = andGate.computeOutput(List(new Signal(a), new Signal(b))).head.getValue
    val orResult = orGate.computeOutput(List(new Signal(a), new Signal(b))).head.getValue
    val xorResult = xorGate.computeOutput(List(new Signal(a), new Signal(b))).head.getValue
    val notA = notGate.computeOutput(List(new Signal(a))).head.getValue
    val notB = notGate.computeOutput(List(new Signal(b))).head.getValue

    // Select output based on operation and operationType
    val output = if (operationType == Bit.Zero) {
      operation match {
        case 0 => Signal(sum)   // ADD
        case 1 => Signal(andResult)  // AND
        case 2 => Signal(notA)   // NOT A
        case 3 => Signal(difference) // SUBTRACT
        case 4 => Signal(xorResult)  // XOR
        case 5 => Signal(orResult) // OR
        case 6 => Signal(a) // PASS A
        case 7 => Signal(Bit.One) // PASS ONE
      }
    } else {
      operation match {
        case 0 => Signal(sum)   // ADD
        case 1 => Signal(orResult) // OR
        case 2 => Signal(andResult)   // AND
        case 3 => Signal(difference) // SUBTRACT
        case 4 => Signal(xorResult)  // XOR
        case 5 => Signal(notA) // NOT A
        case 6 => Signal(a) // PASS A
        case 7 => Signal(notB) // NOT B
      }
    }

    Outputs.head.setValue(output.getValue)
    Outputs(1).setValue(adder.getOutput(1).getValue) // carry out of the adder
    Outputs
  }
}

package com.example.Recipe_db.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

@Entity
public class RecipeInstruction {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")

    private String instructionId;

    @Column(length = 1500)
    private String instructions;

    public RecipeInstruction(String instructions) {
        this.instructions = instructions;
    }
    public RecipeInstruction(){

    }

    public String getInstructionId() {
        return instructionId;
    }



    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeInstruction that = (RecipeInstruction) o;
        return Objects.equals(instructionId, that.instructionId) &&
                Objects.equals(instructions, that.instructions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instructionId, instructions);
    }

    @Override
    public String toString() {
        return "RecipeInstruction{" +
                "instructionId='" + instructionId + '\'' +
                ", instructions='" + instructions + '\'' +
                '}';
    }
}





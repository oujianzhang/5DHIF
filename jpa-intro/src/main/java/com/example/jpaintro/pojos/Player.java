package com.example.jpaintro.pojos;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Player {
    @Id
    private Long playerId;

    @JoinTable
    @ManyToMany(mappedBy = "players")
    private List<Team> teams = new ArrayList<>();
}

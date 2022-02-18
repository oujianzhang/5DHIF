package com.example.jpaintro.pojos;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Team {
    @Id
    private Long teamId;

    @JoinTable
    @ManyToMany
    private List<Player> players = new ArrayList<>();
}

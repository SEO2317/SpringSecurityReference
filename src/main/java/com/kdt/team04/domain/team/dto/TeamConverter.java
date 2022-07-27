package com.kdt.team04.domain.team.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kdt.team04.domain.team.entity.Team;
import com.kdt.team04.domain.teammember.dto.TeamMemberResponse;
import com.kdt.team04.domain.user.UserConverter;
import com.kdt.team04.domain.user.dto.UserResponse;
import com.kdt.team04.domain.user.entity.User;

@Component
public class TeamConverter {

	private final UserConverter userConverter;

	public TeamConverter(UserConverter userConverter) {
		this.userConverter = userConverter;
	}

	public User toUser(UserResponse userResponse) {
		return new User(userResponse.id(), userResponse.password(), userResponse.username(), userResponse.nickname());
	}

	public Team toTeam(TeamResponse response) {
		return Team.builder()
			.id(response.id())
			.name(response.teamName())
			.description(response.description())
			.leader(userConverter.toUser(response.leader()))
			.build();
	}

	public TeamResponse toTeamResponse(Team team) {
		return TeamResponse.builder()
			.id(team.getId())
			.teamName(team.getName())
			.sportsCategory(team.getSportsCategory())
			.description(team.getDescription())
			.leader(userConverter.toUserResponse(team.getLeader()))
			.build();
	}

	public TeamResponse toTeamResponse(Team team, List<TeamMemberResponse> teamMemberResponses) {
		return TeamResponse.builder()
			.id(team.getId())
			.teamName(team.getName())
			.members(teamMemberResponses)
			.sportsCategory(team.getSportsCategory())
			.description(team.getDescription())
			.leader(userConverter.toUserResponse(team.getLeader()))
			.build();
	}
}

package com.kdt.team04.domain.matches.review.repository;

import com.kdt.team04.domain.matches.review.dto.response.MatchRecordTotalResponse;

public interface MatchRecordRepositoryCustom {
	MatchRecordTotalResponse getTeamTotalCount(Long teamId);
}
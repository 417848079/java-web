SELECT
	* 
FROM
	coach_club_service 
WHERE
	coach_club_service_id = "1598590937200594945";
SELECT
	* 
FROM
	sports_club_coach 
WHERE
	sports_club_id = "1594967995601956865";
SELECT
	* 
FROM
	user_sports_service 
WHERE
	user_sports_service_id = "1538825325513850896";
SELECT
	* 
FROM
	coach_club_service 
WHERE
	coach_service_id = "1598590937200594945";
SELECT
	* 
FROM
	sports_club_coach 
WHERE
	sports_club_id = "1594967995601956865";
SELECT
	scc.service_club_coach_id,
	c.coach_id,
	uai.true_name,
	ccs.class_num,
	scc.coach_club_service_id 
FROM
	lzbx_pe_v2.service_club_coach scc
	LEFT JOIN lzbx_pe_v2.coach c ON c.coach_id = scc.coach_id
	LEFT JOIN lzbx_usercenter_v2.user_auth_info uai ON uai.user_id = c.user_id
	LEFT JOIN lzbx_pe_v2.coach_club_service ccs ON ccs.coach_club_service_id = scc.coach_club_service_id 
WHERE
	ccs.coach_club_service_id = 1599582053527900162;
	
	
	
	
SELECT
	c.coach_id,
	uai.true_name,
	ccs.class_num,
	ccs.coach_club_service_id 
FROM
	lzbx_pe_v2.coach_club_service ccs
	LEFT JOIN lzbx_pe_v2.coach_service_V2 csv ON csv.coach_service_id = ccs.coach_service_id
	LEFT JOIN lzbx_pe_v2.coach c ON c.coach_id = csv.coach_id
	LEFT JOIN lzbx_usercenter_v2.user_auth_info uai ON uai.user_id = c.user_id
	LEFT JOIN lzbx_pe_v2.coach_club_service ccs ON ccs.coach_club_service_id = scc.coach_club_service_id 
WHERE
	ccs.coach_club_service_id = 1600408258279440386;
	
	
	
SELECT
	ch.coach_id,
	ch.user_id,
	udi.province_id,
	udi.city_id,
	udi.county_id 
FROM
	lzbx_pe_v2.coach ch
	LEFT JOIN lzbx_usercenter_v2.user_detail_info udi ON udi.user_id = ch.user_id;
WHERE
	ch.coach_id = 1601148123517153281;
	
SELECT
*
FROM
	lzbx_pe_v2.coach ch
	LEFT JOIN lzbx_usercenter_v2.user_detail_info udi ON ch.user_id = udi.user_id;
WHERE
	ch.coach_id = 1601148123517153281;
	
	SELECT * FROM lzbx_usercenter_v2.user_detail_info WHERE user_id = 1165867314148007938;
	
	
	
SELECT
	ch.coach_id,
	ch.user_id
FROM
	lzbx_pe_v2.coach ch
	
WHERE
	ch.coach_id = 1601148123517153281;
 
 
 
SELECT
	* 
FROM
	lzbx_pe_v2.coach ch
	LEFT JOIN lzbx_usercenter_v2.user_detail_info udi ON ch.user_id = udi.user_id;
WHERE
	ch.coach_id = 1538825325513850882;

	
	
	
	
	
	
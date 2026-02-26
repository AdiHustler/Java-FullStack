package com.capgemini.SpringBoot_Basic;

public interface HumanRepositry extends JpaRepositry<Human,Integer>{
	
	
	@Modifying
	@Transactional
	@Query("delete from Human h where h.name=:iname")
	public void deleteHuman(@Param("iname") String name);
}

package com.partyroom.partyroomapi.repository.crud;

import org.springframework.data.repository.CrudRepository;

import com.partyroom.partyroomapi.model.Message;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {

}

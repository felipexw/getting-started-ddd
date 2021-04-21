package com.github.felpexw.academic.domain.command;

import com.github.felpexw.academic.domain.event.StudentRegisteredToClassRoomEvent;
import com.github.felpexw.academic.domain.model.Student;
import com.github.felpexw.academic.domain.repository.ClassRoomRepository;
import com.github.felpexw.shared.domain.common.DomainEventPublisher;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegisterStudentToClassCommand {
	private final DomainEventPublisher publisher;
	private final ClassRoomRepository repository;

	public void registerStudentToClassRoom(Student student) {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		repository.registerStudent(student);
		publisher.publish(new StudentRegisteredToClassRoomEvent(student.getCpf()));
	}

}

package ru.lab_4.tests;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import ru.lab_4.MoneyLagger;

import static org.mockito.Mockito.*;

public class MoneyLaggerTest {
	
	private MoneyLagger ml;
	
	@Before
	public void init() {
		ml = mock(MoneyLagger.class);
	}
	
	@Test
	public void commiteTest() throws IOException {
		ml.commit();
		verify(ml).commit();
	}

	@Test
	public void logTest() throws Exception {
		ml.log("Тестирование фунции log.");
		verify(ml).log("Тестирование фунции log.");
	}
}

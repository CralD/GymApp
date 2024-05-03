package com.epam.gymapplication.utils;
import com.epam.gymapplication.model.Trainee;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StorageInitializerTest {
  /*  @Mock
    private CommonInMemoryStorage storage;

    @Mock
    private Environment env;

    @InjectMocks
    private StorageInitializer storageInitializer;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testInitializeStorage() throws IOException {

        String traineeFilePath = "src/main/resources/data/traineeFile.csv";
        String trainerFilePath = "src/main/resources/data/trainerFile.csv";
        String trainingFilePath = "src/main/resources/data/trainingFile.csv";

        when(env.getProperty("traineeFilePath")).thenReturn(traineeFilePath);
        when(env.getProperty("trainerFilePath")).thenReturn(trainerFilePath);
        when(env.getProperty("trainingFilePath")).thenReturn(trainingFilePath);



        storageInitializer.initializeStorage();

        // Add assertions or verifications here
        verify(env, times(1)).getProperty("traineeFilePath");
        verify(env, times(1)).getProperty("trainerFilePath");
        verify(env, times(1)).getProperty("trainingFilePath");
    }*/



}
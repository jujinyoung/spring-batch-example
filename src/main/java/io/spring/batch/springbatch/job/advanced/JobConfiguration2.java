package io.spring.batch.springbatch.job.advanced;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@RequiredArgsConstructor
//@Configuration
public class JobConfiguration2 {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

//    @Bean
    public Job batchJob2(){
        return jobBuilderFactory.get("batchJob2")
                .incrementer(new RunIdIncrementer())
                .start(step3())
                .next(step4())
                .build();
    }

//    @Bean
    public Step step3() {
        return stepBuilderFactory.get("step3")
                .tasklet((stepContribution, chunkContext) -> {
                    System.out.println(" =========================");
                    System.out.println(" >> step3 Spring Batch!!");
                    System.out.println(" =========================");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }

//    @Bean
    public Step step4() {
        return stepBuilderFactory.get("step4")
                .tasklet((stepContribution, chunkContext) -> {
                    System.out.println(" =========================");
                    System.out.println(" >> step4 Spring Batch!!");
                    System.out.println(" =========================");

                    return RepeatStatus.FINISHED;
                })
                .build();
    }
}

package io.spring.batch.springbatch.job.advanced.job.simplejob;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@RequiredArgsConstructor
//@Configuration
public class ValidatorConfiguration {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

//    @Bean
    public Job batchJob(){
        return jobBuilderFactory.get("validJob")
                .start(step1())
                .next(step2())
                .next(step3())
                .validator(new CustomJobParametersValidators())
                .incrementer(new CustomJobParametersIncrementer())
                .build();
    }

//    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .tasklet((stepContribution, chunkContext) -> {
                    System.out.println(" =========================");
                    System.out.println(" >> step1 Spring Batch!!");
                    System.out.println(" =========================");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }

//    @Bean
    public Step step2() {
        return stepBuilderFactory.get("step2")
                .tasklet((stepContribution, chunkContext) -> {
                    System.out.println(" =========================");
                    System.out.println(" >> step2 Spring Batch!!");
                    System.out.println(" =========================");

                    return RepeatStatus.FINISHED;
                })
                .build();
    }

//    @Bean
    public Step step3() {
        return stepBuilderFactory.get("step3")
                .tasklet((stepContribution, chunkContext) -> {
                    chunkContext.getStepContext().getStepExecution().setStatus(BatchStatus.FAILED);
                    stepContribution.setExitStatus(ExitStatus.STOPPED);
                    System.out.println(" =========================");
                    System.out.println(" >> step3 Spring Batch!!");
                    System.out.println(" =========================");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }
}

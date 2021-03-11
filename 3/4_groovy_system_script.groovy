import jenkins.model.Jenkins;
def target = binding.variables["target"]
def svr = Jenkins.instance;
def job = svr.getJob(target);
def sched = job.scheduleBuild2(0);
sched.get();
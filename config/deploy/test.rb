set :stage, :test

set :profile, "test"

set :deploy_to, "/data/JavaWeb/WechartExam"

set :jar_pid, "/data/JavaWeb/WechartExam/pids/application.pid"

set :server_name, "43.241.234.241"

set :branch, "master"

set :default_env, {
  'PATH' => 'PATH=/usr/dev/jdk1.8.0_131/bin:$PATH'
}

server fetch(:server_name), user: 'dev', roles: %w{web app}


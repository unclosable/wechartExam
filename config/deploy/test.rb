set :stage, :test

set :profile, "test"

set :deploy_to, "/data/JavaWeb/WechartExam"

set :jar_pid, "#{shared_path}/tmp/pids/application.pid"

set :server_name, "43.241.234.241"

set :branch, "master"

set :default_env, {
  'PATH' => 'PATH=/home/work/jdk1.8.0_131/bin:$PATH'
}

server fetch(:server_name), user: 'root', roles: %w{web app}


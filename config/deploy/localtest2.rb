set :stage, :localtest2

set :profile, "localtest2"

set :deploy_to, "/home/web-server/consul-test2"

set :jar_pid, "/home/web-server/consul-test2/shared/tmp/pids/application.pid"

set :server_name, "10.3.22.43"

set :branch, "master"

set :default_env, {
  'PATH' => 'PATH=/usr/java/jdk1.8.0_131/bin:$PATH'
}

server fetch(:server_name), user: 'searcher', roles: %w{web app}


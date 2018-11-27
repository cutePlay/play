/*global module:false*/
module.exports = function(grunt) {
  var livePort = 35880;

  // Project configuration.
  grunt.initConfig({
    // Metadata.
    pkg: grunt.file.readJSON('package.json'),
    cfg: {
      port: 8800,
      hostname: 'localhost',
      base: 'app',
      open: true,
      livereload: livePort
    },
    banner: '/*! <%= pkg.title || pkg.name %> - v<%= pkg.version %> - ' +
      '<%= grunt.template.today("yyyy-mm-dd") %>\n' +
      '<%= pkg.homepage ? "* " + pkg.homepage + "\\n" : "" %>' +
      '* Copyright (c) <%= grunt.template.today("yyyy") %> <%= pkg.author.name %>;' +
      ' Licensed <%= pkg.licenses %> */\n',
    // Task configuration.
    concat: {
      options: {
        banner: '<%= banner %>',
        stripBanners: true,
      },
      dist: {
        src: ['app/src/**/*.js'],
        dest: 'app/scripts/<%= pkg.name %>.js'
      }
    },
    uglify: {
      options: {
        banner: '<%= banner %>'
      },
      dist: {
        src: '<%= concat.dist.dest %>',
        dest: 'app/scripts/<%= pkg.name %>.min.js'
      }
    },
    jshint: {
      options: {
        // curly: true,
        // eqeqeq: true,
        // immed: true,
        // latedef: true,
        // newcap: true,
        // noarg: true,
        // sub: true,
        // undef: true,
        // unused: true,
        // boss: true,
        // eqnull: true,
        // browser: true,
        globals: {
          jQuery: true,
          console: true,
          module: true,
          document: true,
          strict: true
        }
      },
      files: ['app/scripts/*.js','Gruntfile.js']
    },
    // qunit: {
    //   files: ['test/**/*.html']
    // },
    watch: {
      srcfiles: {
        files: ['<%= concat.dist.src %>','app/index.html'],
        tasks: ['diff']
      },
      bowerdiff: {
        files: ['bower.json'],
        tasks: ['wiredep']
      },
      livereload: {
        files: ['app/index.html','app/templates/**/*.html','app/scripts/*.js','app/images/**/*.*','app/styles/**/*.css'],
        options: {
          livereload: livePort
        }
      }
    },
    wiredep: {
      task: {
        src: ['app/index.html']
      }
    },
    connect: {
      options: '<%= cfg %>',
      server: {

      }
    },
  });

  // These plugins provide necessary tasks.
  grunt.loadNpmTasks('grunt-contrib-concat');
  grunt.loadNpmTasks('grunt-contrib-uglify');
  // grunt.loadNpmTasks('grunt-contrib-qunit');
  grunt.loadNpmTasks('grunt-contrib-jshint');
  grunt.loadNpmTasks('grunt-contrib-watch');
  grunt.loadNpmTasks('grunt-contrib-connect');
  grunt.loadNpmTasks('grunt-wiredep');

  // Default task.
  // grunt.registerTask('default', ['jshint', 'qunit', 'concat', 'uglify']);
  grunt.registerTask('start', ['concat','wiredep', 'uglify', 'connect', 'watch']);
  grunt.registerTask('diff', ['concat','uglify']);

};

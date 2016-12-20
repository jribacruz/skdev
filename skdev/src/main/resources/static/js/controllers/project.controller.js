(function() {
	'use strict';

	angular.module('skdevMD').controller('ProjectCT', ProjectCT);

	ProjectCT.$inject = [ '$scope', '$log', 'ProjectSV', '$mdDialog', '$http', 'HttpSV', '$location' ];

	/**
	 * 
	 * @param $scope
	 * @param $log
	 * @param ProjectSV
	 * @param $mdDialog
	 * @param $http
	 * @param HttpSV
	 * @returns
	 */
	function ProjectCT($scope, $log, ProjectSV, $mdDialog, $http, HttpSV, $location) {
		$log.debug('[ProjectCT] Inicializando...');
		var self = this;

		self.projectName = "";

		self.classes = [];

		self.findAllClassesLoader = true;

		init();

		/**
		 * 
		 */
		function init() {
			self.projectName = HttpSV.getProjectName();
			findAllClasses();
		}

		/**
		 * 
		 */
		function findAllClasses() {
			HttpSV.get('/project/classes', {
				queryParams : {
					name : self.projectName
				}
			}).then(function(data) {
				self.classes = data;
				self.findAllClassesLoader = false;
			});
		}

	}
})();
